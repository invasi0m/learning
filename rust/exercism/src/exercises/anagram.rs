use crate::exercises::test_result;
use std::collections::HashSet;

fn normalize(word: &str) -> String {
    let mut letters: Vec<char> = word.to_uppercase().chars().collect();
    /* Using sort_unstable() is generally faster when you don't need a stable sort. */
    letters.sort_unstable();
    letters.into_iter().collect()
}

pub fn anagrams_for<'a>(word: &'a str, candidates: &'a [&'a str]) -> HashSet<&'a str> {
    let normalized_word = normalize(word);
    candidates
        .iter()
        .filter(|&&candidate| {
            // Exclude words that are the same as the original (ignoring case)
            candidate.to_uppercase() != word.to_uppercase()
                && normalize(candidate) == normalized_word
        })
        .copied()
        .collect()
}

pub fn test() {
    let word = "sToP";
    let possible_anagrams = ["stop", "sTop", "posT", "PoST", "OsTP"];
    test_result::test(
        "Anagram",
        format!(
            "Anagrams for '{word}' in {:?} are {:?}",
            possible_anagrams,
            anagrams_for(word, &possible_anagrams)
        ),
    )
}
