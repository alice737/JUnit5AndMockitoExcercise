package pl.exercise.tests.account;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import pl.exercise.tests.account.Account;
import pl.exercise.tests.account.Address;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

/*hamcrest matchers*/

class AccountTest {
    @Test
    void newlyCreatedAccountShouldBeNotActive() {
        Account account = new Account();
        assertFalse(account.isActive());
        assertThat(account.isActive(), equalTo(false));
        assertThat(account.isActive(), is(false));
    }


    @Test
    void defaultDeliveryAddressShouldBeNull() {
        Account account = new Account();
        assertNull(account.getDefaultDeliveryAddress());
        assertThat(account.getDefaultDeliveryAddress(), is(nullValue()));

    }

    @DisplayName("Adress Not Null")
    @Test
    void defaultDeliveryAddressNotNull() {
        Account account = new Account();
        Address address = new Address("77", "Krakowska");
        account.setDefaultDeliveryAddress(address);
        Address address1 = account.getDefaultDeliveryAddress();
        assertNotNull(address1);
        assertThat(address1, is(notNullValue()));
    }
    @RepeatedTest(10)
    void addressIsValid() {
        Address address = new Address("71", "Kwiatowa");
        assertAll("address",
                () -> assertEquals("71", address.getNumber()),
                () -> assertEquals("Kwiatowa", address.getStreet())

        );

    }


}