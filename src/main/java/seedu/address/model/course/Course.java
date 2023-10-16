package seedu.address.model.course;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Set;

import seedu.address.storage.JsonCourseParser;

/**
 * Represents a Course in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidCourseName(String)}
 */
public class Course {

    public static final String MESSAGE_CONSTRAINTS = "Course module ID should consist of letters and numbers";
    public static final String MESSAGE_INVALID = "Course module ID is invalid";
    public static final String MODULE_ID_VALIDATION_REGEX = "^[A-Za-z0-9]+$";
    private static Set<String> courseList;
    public final String courseName;

    /**
     * Constructs a {@code Course}.
     *
     * @param courseName A valid course name.
     */
    public Course(String courseName) {
        requireNonNull(courseName);
        checkArgument(isValidCourseName(courseName), MESSAGE_CONSTRAINTS);
        checkArgument(isExistingCourseName(courseName.toUpperCase()), MESSAGE_INVALID);
        this.courseName = courseName.toUpperCase();
    }

    /**
     * Constructs a {@code Course}.
     *
     * @param courseList A valid course name.
     */
    public static void initialiseCourseList(Set<String> courseList) {
        Course.courseList = courseList;
    }

    /**
     * Returns true if a given string is a valid course name.
     */
    public static boolean isValidCourseName(String test) {
        return test.matches(MODULE_ID_VALIDATION_REGEX);
    }

    /**
     * Returns true if a given string is an existing course
     * and is in the course list.
     */
    public static boolean isExistingCourseName(String test) {
        if (courseList == null) {
            JsonCourseParser.initialise();
        }
        return courseList.contains(test);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof seedu.address.model.course.Course)) {
            return false;
        }
        seedu.address.model.course.Course otherCourse = (seedu.address.model.course.Course) other;
        return courseName.equals(otherCourse.courseName);
    }

    @Override
    public int hashCode() {
        return courseName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + courseName + ']';
    }
}