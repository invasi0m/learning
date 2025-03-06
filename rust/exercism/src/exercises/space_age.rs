use crate::exercises::test_result;

#[derive(Debug)]
pub struct Duration {
    years: f64,
}

impl From<u64> for Duration {
    fn from(s: u64) -> Self {
        let earth_seconds: f64 = 31557600.0;
        let years = s as f64 / earth_seconds;
        Duration { years }
    }
}

pub trait Planet {
    const PERIOD: f64;
    fn years_during(d: &Duration) -> f64 {
        d.years / Self::PERIOD
    }
}

#[derive(Debug)]
pub struct Mercury;
#[derive(Debug)]
pub struct Venus;
#[derive(Debug)]
pub struct Earth;
#[derive(Debug)]
pub struct Mars;
#[derive(Debug)]
pub struct Jupiter;
#[derive(Debug)]
pub struct Saturn;
#[derive(Debug)]
pub struct Uranus;
#[derive(Debug)]
pub struct Neptune;

impl Planet for Mercury {
    const PERIOD: f64 = 0.2408467;
}
impl Planet for Venus {
    const PERIOD: f64 = 0.61519726;
}
impl Planet for Earth {
    const PERIOD: f64 = 1.0;
}
impl Planet for Mars {
    const PERIOD: f64 = 1.8808158;
}
impl Planet for Jupiter {
    const PERIOD: f64 = 11.862615;
}
impl Planet for Saturn {
    const PERIOD: f64 = 29.447498;
}
impl Planet for Uranus {
    const PERIOD: f64 = 84.016846;
}
impl Planet for Neptune {
    const PERIOD: f64 = 164.79132;
}


pub fn test() {
    let seconds = 31557600;
    let planet = Mars;
    let duration = Duration::from(seconds);
    test_result::test(
        "Space Age",
        format!(
            "Space Age for {:?} seconds within {:?} are {:?} years",
            seconds,
            planet,
            Mars::years_during(&duration)
        ),
    )
}
