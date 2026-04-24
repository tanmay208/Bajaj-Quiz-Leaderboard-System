Quiz Leaderboard System
Overview
The Quiz Leaderboard System is a Java-based application designed to interact with a remote quiz API. It fetches live quiz event data by polling an endpoint multiple times, processes the incoming events to filter out duplicates, aggregates the scores for each participant, and constructs a leaderboard. Finally, the application submits the sorted leaderboard back to the server for validation.

Key Features
Data Polling: Sequentially polls the remote quiz server API 10 times to collect live quiz event data.
Rate Limiting Handling: Respects the server's rate limits by implementing a mandatory 5-second delay between consecutive polling requests.
Event Deduplication: Uses a combination of roundId and participant to ensure that duplicate events are ignored, preventing skewed scores.
Score Aggregation: Computes the total score for each participant across all valid quiz rounds.
Leaderboard Generation: Sorts participants based on their aggregated scores in descending order.
Automated Submission: Submits the final leaderboard via a POST request and processes the validation response to ensure correctness.
Technology Stack
Language: Java 21
Build Tool: Maven
HTTP Client: Native Java java.net.http.HttpClient
JSON Processing: Jackson Databind (com.fasterxml.jackson.core:jackson-databind)
Project Structure
QuizLeaderboardSystem/
├── pom.xml                   # Maven configuration and dependencies
└── src/
    └── main/
        └── java/
            └── com/
                └── srmquiz/
                    ├── App.java                   # Main application entry point containing the core logic
                    └── models/                    # Data Transfer Objects (DTOs) for JSON serialization/deserialization
                        ├── ParticipantScore.java  # Represents a participant and their total score
                        ├── QuizEvent.java         # Represents a single event received from the API
                        ├── QuizResponse.java      # Wrapper for the response from the polling endpoint
                        ├── SubmitRequest.java     # Request payload for submitting the leaderboard
                        └── SubmitResponse.java    # Response payload received after submission
How It Works (Application Flow)
Initialize HTTP Client & JSON Mapper: Sets up Jackson's ObjectMapper and Java's native HttpClient.
Polling Loop: Runs a loop 10 times (poll indexes 0 to 9).
Makes a GET request to the /quiz/messages endpoint with a specific regNo and current poll index.
Parses the incoming JSON containing a list of QuizEvent objects.
Data Processing:
Checks if the event (roundId + "-" + participant) has already been processed using a HashSet.
If it's a new unique event, adds the event's score to the participant's total in a HashMap.
Mandatory Wait: Pauses execution for 5 seconds before the next poll iteration.
Leaderboard Construction: Converts the aggregated HashMap into a List of ParticipantScore objects and sorts it by totalScore in descending order.
Submission:
Wraps the sorted list into a SubmitRequest object.
Serializes the request to JSON.
Sends a POST request to the /quiz/submit endpoint.
Validation Output: Parses the submission response and prints whether the submitted leaderboard was validated as correct or incorrect.
