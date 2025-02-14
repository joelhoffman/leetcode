class ProductOfNumbers {
    int product = 1;
    List<Integer> prefixes = new ArrayList<>();

    public ProductOfNumbers() {
    }
    
    public void add(int num) {
        if (num == 0) {
            prefixes.clear();
            product = 1;
        } else {
            product *= num;
            prefixes.add(product);
        
        }
    }
    
    public int getProduct(int k) {
        if (k > prefixes.size()) {
            return 0;
        }
        if (k == prefixes.size()) {
            return product;
        }
        int idx = prefixes.size() - k - 1;
        return product / prefixes.get(idx);
    }
}
