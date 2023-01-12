# A1 - Piraten Karpen

  * Author: < You name here >
  * Email: < Your email here >

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * < Your DoD goes here >

### Backlog 


| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice |  D | 01/09/23 | 01/10/23 |
| x   | F02 | Roll 8 dices | D | 01/11/23 | 01/11/23 |
| x   | F03 | Two players in a game | D  |  01/12/23 |
| x   | F04 | Player keeping random dice at their turn | B (F02) | |
| x   | F05 | 100 points per diamond and gold faces from the dice kept aside | B (F05) | |
| x   | F06 | Track all points per round in order to know which player won the round| B (F06) | |
| x   | F07 | 2000 points means a player wins | B (F07) | |
| x   | F08 | 3 skulls causes player to loose all points for that round and round ends | P | |
| x   | F09 | percentage of wins for each player per round for that game | B (F07) | | 
