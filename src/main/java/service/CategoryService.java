package service;

import dao.CategoryDAO;
import model.Category;

import java.util.List;

public class CategoryService {

    private final CategoryDAO categoryDAO = new CategoryDAO();

    public void saveCategory(Category category) {
        categoryDAO.saveCategory(category);
    }

    public void updateCategory(Category category) {
        categoryDAO.updateCategory(category);
    }

    public Category getCategoryById(int id) {
        return categoryDAO.getCategoryById(id);
    }

    public void deleteCategory(int id) {
        categoryDAO.deleteCategory(id);
    }

    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }
}
