use std::fmt;
use std::fmt::Formatter;

enum TestResult {
    TestResult(String, String),
}

impl fmt::Display for TestResult {
    fn fmt(&self, f: &mut Formatter<'_>) -> fmt::Result {
        match self {
            TestResult::TestResult(header, res) => {
                let str = format!(
                    "Result for exercise '{}' is:\n >> {}",
                    header, res
                );
                write!(f, "{}", str)
            }
        }
    }
}
pub fn test(exercise: &str, result: String) {
    println!("{}", TestResult::TestResult(exercise.to_string(), result))
}
