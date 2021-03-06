# DDD-2021q2
Practice designing a project solution using Eric Evans DDD principals

# Requirements
- Make a GitHub Repo​
- Invite instructors (and team members if any)​
- Pick a complex system to model (ideas on next slide)​
- Do a DDD using any/all of the following:​
  - DDD Diagrams in UML/MS/C4 Notation ​
  - Classes, Enums, etc. e.g. classes and namespaces ​
  - SQL or other schema that represents the mapping of DDD to storage​
  - As you work through the problem, PR the instructors​
  - We’ll provide feedback, and ultimately CE Credits​

# Introduction
- this project will be based on a Course Registration System for a University
- the different domains will be Courses, Registrations, Users, and Library
- The final solution will be a Springboot application, implemented from the diagrams.

# Zoom 0
  - show domains as a shape, and design to show the relations between 
domains
  - Zoom 0 diagram found here: https://www.yworks.com/yed-live/?file=https://gist.githubusercontent.com/row49382/f1f892de884141d99949db2cb83cf239/raw/cf0954312c59d73194df2bad5e2b1d6217e4628c/Domain%20Driven%20Design%3A%20University%20Course%20Registration%20System

  # Zoom 1
  - shows the detailed services exposed by a domain and the large context-maps within the domain
  - Zoom 1 diagram found here:  https://www.yworks.com/yed-live/?file=https://gist.githubusercontent.com/row49382/520fdbb84ff2a5bb1b3c6280c4ddd508/raw/573038e36aec5c25ca99b9dbde61033ade7e76ff/Domain%20Driven%20Design%3A%20University%20Course%20Registration%20System

  # Zoom 2
  - breaks down a single context map to show aggregates, entities and value-objects
  - NOTE: for zoom 2 and 3, the following lines will mean the following:
    - black arrow: association
    - white arrow: composition
    - dashed black arrow: set
    - solid line: inheritance
  - Zoom 2 diagram found here: https://www.yworks.com/yed-live/?file=https://gist.githubusercontent.com/row49382/878fb199700876cc341c0e872188eb8f/raw/75d7656f5a8ca4aa987ca2e4b530dec69e6c8601/Domain%20Driven%20Design%3A%20University%20Course%20Registration%20System

  # Zoom 3
  - For a single structure (see list above) show implementation details and related types, validations, nullability, defaults, interfaces, and value objects. It can also include the embedded types (which may be value-objects or entities)​
  - Zoom 3 diagram for CourseRegistration found here: https://www.yworks.com/yed-live/?file=https://gist.githubusercontent.com/row49382/05f480dcab9715a7bfd2dc45925a6e39/raw/f32f64aa15509fb09e150f9bd9529dec4221fa67/Domain%20Driven%20Design%3A%20University%20Course%20Registration%20System