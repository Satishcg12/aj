package bean;

class BeanProgram {
  public static void main(String[] args) {
    // SimpleBean demo
    SimpleBean simpleBean = new SimpleBean();
    simpleBean.setName("John Doe");
    simpleBean.setActive(true);
    simpleBean.setScores(new int[] { 90, 85, 78 });
    System.out.println("SimpleBean: " + simpleBean.getName() + 
                       "\n Active: " + simpleBean.isActive() + 
                       "\n Score[1]: " + simpleBean.getScore(1));
    
    // SingletonBean demo
    SingletonBean singleton1 = SingletonBean.getInstance();
    singleton1.setMessage("Modified message");
    SingletonBean singleton2 = SingletonBean.getInstance();
    System.out.println("\nSingletonBean: same instance = " + (singleton1 == singleton2) + 
                       "\n message: " + singleton1.getMessage());
    
    // FactoryBean demo
    SimpleBean factorySimpleBean = (SimpleBean) FactoryBean.createBean("simple");
    factorySimpleBean.setName("Factory Bean");
    SingletonBean factorySingletonBean = (SingletonBean) FactoryBean.createBean("singleton");
    System.out.println("\nFactoryBean: simple = " + factorySimpleBean.getName() + 
                       "\n singleton = " + factorySingletonBean.getMessage());
    
    // Adapter demo
    LegacyUser legacyUser = new LegacyUser("Jane Doe", 30);
    UserAdapter userAdapter = new UserAdapter(legacyUser);
    System.out.println("\nAdapter: name = " + userAdapter.getName() + 
                       "\n age = " + userAdapter.getAge());
  }
}