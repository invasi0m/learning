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

macro_rules! planet {
    ($adt:ident, $p:expr) => {
        #[derive(Debug)]
        pub struct $adt;
        impl Planet for $adt {
            const PERIOD: f64 = $p;
        }
    };
}

planet!(Earth, 1.0);

planet!(Mercury, 0.2408467);

planet!(Venus, 0.61519726);

planet!(Mars, 1.8808158);

planet!(Jupiter, 11.862615);

planet!(Saturn, 29.447498);

planet!(Uranus, 84.016846);

planet!(Neptune, 164.79132);

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
