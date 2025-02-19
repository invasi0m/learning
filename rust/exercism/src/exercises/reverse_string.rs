use crate::exercises::test_result;

pub fn reverse<'a>(s: &str) -> String {
    s.chars().rev().collect()
}

pub fn test() {
    let word = "Hello güys";
    let reverse_word = reverse(word);

    test_result::test(
        "Reverse",
        format!("The reverse word of '{}' is '{}'", word, reverse_word),
    )
}
