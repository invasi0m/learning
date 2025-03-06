use crate::exercises::test_result;
use std::fmt::{Display, Formatter};

#[derive(Debug)]
pub struct Clock {
    hours: i32,
    minutes: i32,
}

impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        let total_minutes = hours * 60 + minutes;
        let normalized_minutes = total_minutes.rem_euclid(24 * 60);
        let hours = normalized_minutes / 60;
        let minutes = normalized_minutes % 60;

        Self { hours, minutes }
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        Self::new(self.hours, self.minutes + minutes)
    }
}

impl Display for Clock {
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
        write!(f, "{:02}:{:02}", self.hours, self.minutes)
    }
}

impl PartialEq for Clock {
    fn eq(&self, other: &Self) -> bool {
        self.hours == other.hours && self.minutes == other.minutes
    }
}

pub fn test() {
    let c1 = Clock::new(-3, 35);
    let c2 = Clock::new(15, -80);
    let c3 = c2.add_minutes(40);

    test_result::test(
        "Clock",
        format!(
            "The clocks are\n c1:= {c1:?} => '{c1}',\n c2:= {c2:?} => '{c2}',\n c3=c1+40m='{c3}'\n and {c1:?}=={c2:?} -> {}",
            c1 == c2
        ),
    )
}
