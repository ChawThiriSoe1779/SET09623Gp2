# USE CASE: 27 Produce a report of number of population of the continent
## CHARACTERISTIC INFORMATION
### Goal in Context
As an employee of the organisation, I want to produce a report of number of population of the continent so that the organisation can report that information.
### Scope
Organization.

### Level
Secondary/additional task.

### Preconditions
Database (world.sql) contains data that needed for report.

### Success End Condition
A report is available for organization to view.

### Failed End Condition
No report is produced.

### Primary Actor
Organization.

### Trigger
When organization want to see the report.

### MAIN SUCCESS SCENARIO
Organization request report about population information in the continent.
The system pull the data from the database and provide the requested report information.

### EXTENSIONS
Continent does not exist:
system inform the organization.

### SUB-VARIATIONS
None.

### SCHEDULE
DUE DATE: Release v01.0.4-alpha
