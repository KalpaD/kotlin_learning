package kotlin_learning._9_references

class Person(val name: String, val age: Int) {
    fun isOlder(ageLimit: Int) = age > ageLimit
}

// a non-bounded reference
val nonBoundAgePredicate = Person::isOlder
val nonBoundAgePredicateExpanded: (Person, Int) -> Boolean = { person, ageLimit -> person.isOlder(ageLimit) }



// bound reference
val alice = Person("Alice", 30)
val boundAgePredicate = alice::isOlder
val boundAgePredicateExpanded: (Int) -> Boolean = alice::isOlder // this reference is bounded to the alice person instance