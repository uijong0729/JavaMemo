package design.builder;

public class Student {
	private int birth;
	private String name;
	private String job;
	private Student(Student.Builder builder) {
		this.birth = builder.birth;
		this.name = builder.name;
		this.job = builder.job;
	}
	
	static class Builder{
		private int birth;
		private String name;
		private String job;
		
		public Builder birth(int birth) {
			this.birth = birth;
			return this;
		}
		
		public Builder age(String name) {
			this.name = name;
			return this;
		}
		
		public Builder job(String job) {
			this.job = job;
			return this;
		}
		
		public Student build() {
			return new Student(this);
		}
	}
}
