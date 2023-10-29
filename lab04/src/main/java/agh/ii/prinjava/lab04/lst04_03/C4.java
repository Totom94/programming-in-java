package agh.ii.prinjava.lab04.lst04_03;

/**
 * We use T for type, whenever there is nothing more specific about the type to distinguish it.
 * This is often the case in generic methods.
 * <ul>
 *     <li>If there are multiple type parameters, we might use letters that neighbour the letter T in the alphabet,
 *         such as S</li>
 *     <li>If a generic method appears inside a generic class, it is a good idea to avoid using the same names
 *         for the type parameters of the method and class to avoid confusion.
 *         The same applies to nested generic classes</li>
 * </ul>
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/extra/generics/methods.html">Generic Methods</a>
 */
class C4<T> { // "T" here refers to a class type parameter
    private T x;

    // "U" stands for a type parameter of the method sm1 (in general it can refer to a different type than "T")
    <U> U sm1(U x) {
        return x;
    }
}
