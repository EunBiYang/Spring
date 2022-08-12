package anno1;

import org.springframework.stereotype.Component;

// <bean id="test" class="anno1.KoreaTire"/> 와 동일한 설정
@Component("test")
public class KoreaTire implements Tire{
		
	@Override
	public String getBrand() {
		return "한국 타이어";
	}
}
