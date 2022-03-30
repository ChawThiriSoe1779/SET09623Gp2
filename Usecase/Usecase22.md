# USE CASE: 22 produce a report of the top populated capital cities in the region by filtering the number of capital cities
## CHARACTERISTIC INFORMATION
### Goal in Context
As an employee of the organisation, I want to produce a report of the top populated capital cities in the region by filtering the number of capital cities so that the organisation can report that information.
### Scope
Organization.

### Level
Primary task.

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
Organization request report about capital cities information by filtering top populated capital cities in the region.
The system pull the data from the database and provide the requested report information.

### EXTENSIONS
Region does not exist:
system inform the organization.

### SUB-VARIATIONS
None.

### SCHEDULE
DUE DATE: Release v01.0.3-alpha
