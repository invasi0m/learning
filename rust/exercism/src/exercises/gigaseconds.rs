use crate::exercises::test_result;
use time::ext::NumericalDuration;
use time::macros::*;
use time::PrimitiveDateTime as DateTime;

// Returns a DateTime one billion seconds after start.
pub fn after(start: DateTime) -> DateTime {
    // start.add(Duration::seconds(1_000_000_000))
    // start + Duration::seconds(1_000_000_000)
    start + 1e9.seconds()
}

pub fn test() {
    let date = datetime!(2025-012-18 00:00:00);
    let new_date = after(date);

    test_result::test(
        "Gigaseconds",
        format!(
            "The new date plus a gigasecond of '{}' is '{}'",
            date, new_date
        ),
    )
}
