package seedu.address.model.person.sorter;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.model.person.Person;

/**
 * A sorter for persons in the address book based on name in ascending lexicographic order.
 * Subclass of {@link PersonSorter}.
 */
public class PersonNameAscendingSorter extends PersonSorter {

    /**
     * Constructs a {@code PersonNameAscendingSorter}.
     */
    public PersonNameAscendingSorter() {
        criterion = "name-ascending";
    }

    @Override
    public int compare(Person person1, Person person2) {
        requireAllNonNull(person1, person2);
        // Convert to uppercase so as to compare ASCII values
        String person1UpperCaseName = person1.getName().fullName.toUpperCase();
        String person2UpperCaseName = person2.getName().fullName.toUpperCase();
        return person1UpperCaseName.compareTo(person2UpperCaseName);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof PersonNameAscendingSorter)) {
            return false;
        }

        PersonNameAscendingSorter otherPersonNameAscendingSorter = (PersonNameAscendingSorter) other;
        return this.getSortingCriterion().equals(otherPersonNameAscendingSorter.getSortingCriterion());
    }

    @Override
    public int hashCode() {
        return criterion.hashCode();
    }
}