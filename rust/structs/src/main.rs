#[derive(Debug)]
struct User {
    id: i32,
    name: String,
    email: String,
    active: bool,
}

fn build_user_email(name: String, email: String) -> User {
    User {
        id: 1,
        name,
        email,
        active: true,
    }
}

fn change_name(user: User, name: String) -> User {
    User { name: name, ..user }
}
#[derive(Debug)]
struct Color(i32, i32, i32);
#[derive(Debug)]
struct Point(i32, i32, i32, Color);

fn main() {
    let user: User = build_user_email(String::from("user"), String::from("user@email.com"));
    println!("User 1 is {:?}", user);
    let user2: User = change_name(user, String::from("user2"));
    println!("User 2 is {:?}", user2);
    println!("Point is {:?}", Point(1, 2, 3, Color(10, 10, 10)))
}

