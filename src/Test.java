import java.sql.ResultSet;
import java.sql.SQLException;

import com.zr.model.dao.MangerDao;
import com.zr.model.dao.StaffDao;
import com.zr.model.service.StaffService;

public class Test {
	public static void main(String[] args) {
		try {
		System.out.println(MangerDao.getMangerNameByMnagerId(1010002));
//			System.out.println(StaffDao.getTotalEmpNumber());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
