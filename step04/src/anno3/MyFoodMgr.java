package anno3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyFoodMgr {
	// 1. bean 객체의 자료형으로 멤버변수에 주입을 함
	// 2. 똑같은 자료형이 여러개 있을 경우, 멤버변수와 이름이 같은 bean 객체를 주입함 
	// 3. 똑같은 자료형이 여러개 있을 경우, 멤버변수와 이름이 다른 bean 객체를 주입하기 위해서는
	//    @Qualifier 어노테이션으로 주입시킬 bean 객체를 설정해야함.
	@Autowired 
	@Qualifier("favorite")
	private Food favoriteFood;
	@Autowired
	@Qualifier("unFavorite")
	private Food unFavoriteFood;
	
	@Override
	public String toString() {
		return "MyFoodMgr [favoriteFood=" + favoriteFood + ",\n unFavoriteFood=" + unFavoriteFood + "]";
	}

	public Food getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public Food getUnFavoriteFood() {
		return unFavoriteFood;
	}

	public void setUnFavoriteFood(Food unFavoriteFood) {
		this.unFavoriteFood = unFavoriteFood;
	}	
}
