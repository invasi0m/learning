mod seal {
    pub trait Sealed {}
    impl Sealed for i64 {}
}

#[derive(Debug)]
pub enum MyBox<T> {
    MyBox(T),
}

pub trait CustomBox<T>: seal::Sealed {
    fn wrap(self) -> MyBox<T>;
}

impl CustomBox<i64> for i64 {
    fn wrap(self) -> MyBox<i64> {
        MyBox::MyBox(self)
    }
}

pub fn play(n: i64) -> MyBox<i64> {
    n.wrap()
}
