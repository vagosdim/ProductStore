// src/ProductList.tsx
import React from 'react';
import { List, Avatar } from 'antd';

interface Product {
  id: number;
  name: string;
  description: string;
  imageUrl: string;
}

const products: Product[] = [
  {
    id: 1,
    name: 'Product 1',
    description: 'Description for Product 1',
    imageUrl: 'https://via.placeholder.com/150',
  },
  {
    id: 2,
    name: 'Product 2',
    description: 'Description for Product 2',
    imageUrl: 'https://via.placeholder.com/150',
  },
  // Add more products as needed
];

const ProductList: React.FC = () => {
  return (
    <div>
      <h1>Product List</h1>
      <List
        itemLayout="horizontal"
        dataSource={products}
        renderItem={item => (
          <List.Item>
            <List.Item.Meta
              avatar={<Avatar src={item.imageUrl} />}
              title={<a href="#">{item.name}</a>}
              description={item.description}
            />
          </List.Item>
        )}
      />
    </div>
  );
};

export default ProductList;