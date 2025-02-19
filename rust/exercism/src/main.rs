use crate::exercises::effect::{Functor, Pure};
use crate::exercises::sealed_custom_box::CustomBox;

mod exercises;

fn main() {
    exercises::reverse_string::test();
    exercises::gigaseconds::test();
}
