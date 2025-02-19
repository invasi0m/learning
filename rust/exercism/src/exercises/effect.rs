#[derive(Debug)]
pub enum Effect<A> {
    Effect(A),
}
pub trait Pure<A> {
    type Wrapped<T>;
    fn pure(self) -> Self::Wrapped<A>;
}

impl<A> Pure<A> for A {
    type Wrapped<T> = Effect<T>;

    fn pure(self) -> Self::Wrapped<A> {
        Effect::Effect(self)
    }
}

pub trait Functor<T> {
    type Wrapped<A>;
    fn fmap<U>(self, f: impl Fn(T) -> U) -> Self::Wrapped<U>;
}

impl<T> Functor<T> for Effect<T> {
    type Wrapped<U> = Effect<U>;

    fn fmap<B>(self, f: impl Fn(T) -> B) -> Self::Wrapped<B> {
        match self {
            Effect::Effect(a) => f(a).pure(),
        }
    }
}

impl<T> Functor<T> for Vec<T> {
    type Wrapped<A> = Vec<A>;

    fn fmap<U>(self, f: impl Fn(T) -> U) -> Self::Wrapped<U> {
        let mut new_vec: Vec<U> = Vec::new();
        for i in self {
            new_vec.push(f(i))
        }
        new_vec
    }
}

pub fn pure<A>(a: A) -> Effect<A> {
    a.pure()
}

pub fn identity<A>(a: A) -> A {
    a
}

pub fn play<A>(a: A) -> Effect<A> {
    a.pure().fmap(identity)
}
