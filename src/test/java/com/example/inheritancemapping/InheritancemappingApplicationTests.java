package com.example.inheritancemapping;

import com.example.inheritancemapping.entities.Cheque;
import com.example.inheritancemapping.entities.CreditCard;
import com.example.inheritancemapping.repos.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InheritancemappingApplicationTests {

	@Autowired
	PaymentRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createPayment()
	{
		CreditCard creditCard=new CreditCard();
		creditCard.setId(123);
		creditCard.setAmount(1000);
		creditCard.setCardnumber("123456789");
		repository.save(creditCard);

	}

	@Test
	public void createChequePayment()
	{
		Cheque cheque=new Cheque();
		cheque.setId(1234);
		cheque.setAmount(1000);
		cheque.setChequenumber("123456789");
		repository.save(cheque);
	}

}
