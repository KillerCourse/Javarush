package Sql.dao.impl;

import Sql.dao.MyProductDao;
import Sql.model.MyProductModel;

public class MyDefaultProductDao implements MyProductDao {

    @Override
    public MyProductModel getProductById(int id) {

        return new MyProductModel();
    }
}
