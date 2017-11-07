package Pr3Mankind;

class Human {

    private String firstName;
    private String lastName;

    Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        if (firstName.charAt(0) != firstName.toUpperCase().charAt(0)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if (firstName.length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    String getLastName() {
        return this.lastName;
    }

    private void setLastName(String lastName) {
        if (lastName.charAt(0) != lastName.toUpperCase().charAt(0)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }
}
