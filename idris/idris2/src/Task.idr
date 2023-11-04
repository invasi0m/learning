data Day:  Type where
      Monday      : Day
      Tuesday     : Day
      Wednesday   : Day
      Thursday    : Day
      Friday      : Day
      Sathurday   : Day
      Sunday      : Day

data TaskType: Type where
        Dev : TaskType
        Stratio: TaskType
        Connectors: TaskType



data Task:  (d:Day) -> (t:TaskType) -> Type where
        Greet:                                  (Task d t)
        Break:                                  (Task d t)
        Planning:       String              ->  (Task Monday Connectors)
        Retro:          String              ->  (Task Friday Connectors)
        Work:           String              ->  (Task d Dev)
        Issue:          Int                 ->  (Task d Dev)
        Imputation:     String -> Int       ->  (Task d Stratio)
        Factorial:      String              ->  (Task d Stratio)





mondayDevTasks: List(Task Monday Dev) -- Se cumple para el dia 'Monday' y el tipo de tarea 'Dev'.
mondayDevTasks = [
                    Work "Integrating kerberos",
                    Work "Implementing discovery process in sscc-s3",
                    Issue 123,
                    Issue 34
                ]

sprintDevTasks: List(Task _ Dev) -- Se cumple para cualquier dia mientras que el tipo de tarea sea 'Dev'.
sprintDevTasks = [
                    Work "Integrating kerberos",
                    Work "Implementing discovery process in sscc-s3",
                    Issue 123,
                    Issue 34
                ]

mondayConnectorsTasks: List(Task Monday Connectors) -- Se cumple para el dia 'Monday' y el tipo de tarea 'Stratio'.
mondayConnectorsTasks = [
                    Greet,
                    Planning "Cogerme 2 tareas"
                ]

employeeEveryDayTasks: List(Task _ Stratio) -- Se cumple para cualquier dia mientras que el tipo de tarea sea 'Stratio'.
employeeEveryDayTasks = [
                Factorial "8:00:00",
                Greet,
                Imputation "CON" 1234,
                Imputation "CON" 784,
                Factorial "14:30:00",
                Break,
                Factorial "15:30:00",
                Factorial "18:30:00"
]

allDayTasks: List(Task _ _)
allDayTasks = [
            Greet,                          -- Se cumple para cualquier dia y cualquier tipo de tarea.
            Break,                          -- Se cumple para cualquier dia y cualquier tipo de tarea.
            -- Work "Integrating kerberos"     -- No puedo porque es un tipo dependiente. Sólo se cumple para el tipo de tarea 'Dev'.
]