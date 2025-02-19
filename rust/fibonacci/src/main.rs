fn main() {
    let number: i32 = 11;
    let result: i32 = fibonacci(number);
    println!("Fibonacci number for {number} is {result}");
}

fn fibonacci(n: i32) -> i32 {
    if n == 0 || n == 1 {
        n
    } else {
        fibonacci(n - 1) + fibonacci(n - 2)
    }
}