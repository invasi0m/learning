use std::io;
fn guess_game() {
    let mut word: String = String::new();
    println!("Give a word:");
    io::stdin()
        .read_line(&mut word)
        .expect("Error guessing word")
        .to_string();

    println!("The guess word is '{}", word);
}

fn main() {
    guess_game();
}
