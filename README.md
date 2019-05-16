# Slug Framework

Slug Framework is created to simplify the code implementation of microservices created on top of Spring Boot. 

This is a preconceived idea to help junior developers implement code easily by eliminating multiple or nested if statement. Also to make the code implementations self documenting as much as possible.


## Features

*   Validation framework that will easily wire business validation classes
*   Business Process framework that easily wire classes that implemented business rules
*   Help production support developers to easily understand the code


## Sample Code
For the example let's consider a Create User use case. 
1. The the following fields must be satisfied first before proceeding to business process
  *   First Name of the User
  *   Last Name of the User
  *   User Identifier

2. Save the user details.

```java
@Service
public class CreateUserService extends AbstractService<UserDTO, ServiceResponse<UserDTO>> {

	private ApplicationContext applicationContext;
	
	@Autowired
	public CreateUserService(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	
	@Override
	protected void initValidators(List<AbstractValidator<UserDTO>> validators) {
		
		validators.add(applicationContext.getBean(FirstNameValidator.class));
		validators.add(applicationContext.getBean(LastNameValidator.class));
		validators.add(applicationContext.getBean(UserIdValidator.class));
		
	}


	@Override
	protected void initProcessors(List<Processor<UserDTO, ServiceResponse<UserDTO>>> processors) {
		
		processors.add(applicationContext.getBean(PrepareDefaults.class));
		processors.add(applicationContext.getBean(CreateUserProcessor.class));
		processors.add(applicationContext.getBean(MapToReponse.class));
		
	}

}
```
