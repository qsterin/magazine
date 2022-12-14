public class Repository {
    protected Product[] products = new Product[0];

    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeByID(int id) throws NotFoundException {
        if (findById(id) == null) {
            System.out.println("ID " + id + " не найден");
            throw new NotFoundException(
                    "ID " + id + " не найден");
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
                products = tmp;
            }
        }
    }

    public Product[] findAll() {
        return products;
    }

}

