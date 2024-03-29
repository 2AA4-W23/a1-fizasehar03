# A1 - Piraten Karpen

  * Author: < Fiza Sehar >
  * Email: < seharf@mcmaster.ca >

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
   * < The step successfully complies, executes and prints desired output while all previous steps still run >

### Backlog 


| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice |  D | 01/09/23 | 01/10/23 |
| x   | F02 | Roll 8 dices | D | 01/11/23 | 01/11/23 |
| x   | F03 | Two players in a game | D  |  01/12/23 |01/15/23|
| x   | F04 | Player rolling random dice at their turn or try to get a combo | P |01/20/23 | 01/22/23|
| x   | F05 | 100 points per diamond and gold faces from the dice kept aside and score points for 3-of a king, 4 of a kind....8 of a kind | D | 01/20/23| 01/20/23|
| x   | F06 | Track all points per round in order to know which player won the round| D | 01/13/23 |01/15/23|
| x   | F06 | Add Sea battle cards, effects each round and track points| D | 01/25/23 |01/28/23|
| x   | F06 | Add monkey cards, effects each round and track points| D | 01/25/23 |01/30/23|
| x   | F07 | 1000 points means a player wins | D | 01/15/23|01/15/23|
| x   | F08 | 3 skulls causes that round ends | D |01/15/23 |01/15/23|
| x   | F09 | percentage of wins for each player per round for that game | D |01/15/23 | 01/15/23|
