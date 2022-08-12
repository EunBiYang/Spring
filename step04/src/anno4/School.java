package anno4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
public class School {
	@Autowired
	public Student student;
//	@Autowired
//	@Qualifier("grade3")
//	public int grade;
	
	// @Resource = @Autowired + @Qualifier
	@Resource(name="grade3")
	public int grade;
	
	@Override
	public String toString() {
		return "School [student=" + student + ", grade=" + grade + "]";
	}	
}
