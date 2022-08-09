package sample3;

public class UserServiceImpl implements UserService{

	@Override
	public void addUser(UserVo vo) {
		System.out.println("이름 : "+ vo.getUserName());
	}

}
