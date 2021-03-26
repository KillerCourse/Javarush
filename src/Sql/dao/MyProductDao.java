package Sql.dao;

import Sql.model.MyProductModel;

/**
 * Provides methods to work with products.
 */
public interface MyProductDao {

    /**
     * Gets product by id.
     *
     * @param id product id, should not be null
     * @return product if found, otherwise returns null
     */
    MyProductModel getProductById(int id);
}
