class ThreadSafeSingleton{
	private static ThreadSafeSingleton instance;

	private ThreadSafeSingleton(){}

	public static synchronized ThreadSafeSynchronized getInstance(){
		if(instance == null){
			instance  = new ThreadSafeSingleton();
		}
		return instance;
	}
}
