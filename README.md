# XML-JSON-Converter
URL :- http://localhost:8080/api/convert
Method:- POST
Content-Type:- xml

Input:- XML

<?xml version="1.0" encoding="UTF-8"?>
<Response>
    <ResultBlock>
        <MatchDetails>
            <Match>
                <Entity>John</Entity>
                <MatchType>Exact</MatchType>
                <Score>35</Score>
            </Match>
            <Match>
                <Entity>Doe</Entity>
                <MatchType>Exact</MatchType>
                <Score>50</Score>
            </Match>
        </MatchDetails>
        <ErrorWarnings>
            <Errors>
                <errorCount>0</errorCount>
            </Errors>
            <Warnings>
                <warningCount>1</warningCount>
                <Warning>
                    <Number>102001</Number>
                    <Message>Minor mismatch in address</Message>
                    <Values>
                        <Value>Bellandur</Value>
                        <Value>Bangalore</Value>
                    </Values>
                </Warning>
            </Warnings>
        </ErrorWarnings>
        <API>
            <RetStatus>SUCCESS</RetStatus>
            <ErrorMessage></ErrorMessage>
            <SysErrorCode></SysErrorCode>
            <SysErrorMessage></SysErrorMessage>
        </API>
    </ResultBlock>
</Response>


Output:-JSON

{
  "Response": {
    "ResultBlock": {
      "MatchSummary": { //new field
        "TotalMatchScore": "85" //new custom field
      },
      "ErrorWarnings": {
        "Errors": {
          "errorCount": "0"
        },
        "Warnings": {
          "warningCount": "1",
          "Warning": {
            "Number": "102001",
            "Message": "Minor mismatch in address",
            "Values": {
              "Value": [ "Bellandur","Bangalore"]
            }
          }
        }
      },
      "MatchDetails": [
        "Match": {
          "Entity": "John",
          "MatchType": "Exact",
          "Score": "35"
        },
        "Match": {
          "Entity": "Doe",
          "MatchType": "Exact",
          "Score": "40"
        }
      ],
      "API": {
        "RetStatus": "SUCCESS",
        "ErrorMessage": null,
        "SysErrorCode": null,
        "SysErrorMessage": null
      }
    }
  }
}
