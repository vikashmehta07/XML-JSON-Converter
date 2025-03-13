package com.example.XmlToJsonApi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;

@Service
public class XmlToJsonService {

    public String convertXmlToJson(String xmlInput) {
        try {
            // Initialize XML & JSON Mapper
            XmlMapper xmlMapper = new XmlMapper();
            ObjectMapper jsonMapper = new ObjectMapper();

            // Converting XML to JSON tree
            JsonNode rootNode = xmlMapper.readTree(xmlInput.getBytes());

            JsonNode resultBlock = rootNode.path("ResultBlock");

            int totalMatchScore = calculateTotalMatchScore(resultBlock.path("MatchDetails"));

            // Constructing the final JSON structure using ObjectNode
            ObjectNode responseNode = jsonMapper.createObjectNode();
            ObjectNode resultBlockNode = jsonMapper.createObjectNode();

            // Adding MatchSummary
            ObjectNode matchSummaryNode = jsonMapper.createObjectNode();
            matchSummaryNode.put("TotalMatchScore", totalMatchScore);
            resultBlockNode.set("MatchSummary", matchSummaryNode);

            // Adding ErrorWarnings, MatchDetails, and API sections (if present)
            if (resultBlock.has("ErrorWarnings")) {
                resultBlockNode.set("ErrorWarnings", resultBlock.get("ErrorWarnings"));
            }
            if (resultBlock.has("MatchDetails")) {
                resultBlockNode.set("MatchDetails", resultBlock.get("MatchDetails"));
            }
            if (resultBlock.has("API")) {
                resultBlockNode.set("API", resultBlock.get("API"));
            }

            // Wraping everything under "ResultBlock"
            ObjectNode responseWrapper = jsonMapper.createObjectNode();
            responseWrapper.set("ResultBlock", resultBlockNode);

            // Wraping "ResultBlock" under "Response"
            responseNode.set("Response", responseWrapper);

            return jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseNode);

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"Failed to process XML\"}";
        }
    }

    private int calculateTotalMatchScore(JsonNode matchDetails) {
        int totalScore = 0;

        if (matchDetails.has("Match")) {
            JsonNode matches = matchDetails.get("Match");

            if (matches.isArray()) {
                for (JsonNode match : matches) {
                    totalScore += getScore(match);
                }
            } else {
                totalScore += getScore(matches);
            }
        }
        return totalScore;
    }

    private int getScore(JsonNode matchNode) {
        if (matchNode.has("Score") && matchNode.get("Score").asText().matches("\\d+")) {
            return matchNode.get("Score").asInt();
        }
        return 0;
    }
}
