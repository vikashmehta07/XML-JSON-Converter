# XML-JSON-Converter
URL -
```console
http://localhost:8080/api/convert
```
Method:- POST

Content-Type:- XML

Input:- XML

```console
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
```

Output:-JSON

```console
{
  "Response" : {
    "ResultBlock" : {
      "MatchSummary" : {
        "TotalMatchScore" : 85
      },
      "ErrorWarnings" : {
        "Errors" : {
          "errorCount" : "0"
        },
        "Warnings" : {
          "warningCount" : "1",
          "Warning" : {
            "Number" : "102001",
            "Message" : "Minor mismatch in address",
            "Values" : {
              "Value" : [ "Bellandur", "Bangalore" ]
            }
          }
        }
      },
      "MatchDetails" : {
        "Match" : [ {
          "Entity" : "John",
          "MatchType" : "Exact",
          "Score" : "35"
        }, {
          "Entity" : "Doe",
          "MatchType" : "Exact",
          "Score" : "50"
        } ]
      },
      "API" : {
        "RetStatus" : "SUCCESS",
        "ErrorMessage" : "",
        "SysErrorCode" : "",
        "SysErrorMessage" : ""
      }
    }
  }
}

```
