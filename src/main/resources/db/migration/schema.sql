CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    senha VARCHAR(255),
    cpf VARCHAR(20),
    endereco VARCHAR(255),
    role VARCHAR(20)
);

CREATE TABLE estabelecimento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    endereco VARCHAR(255),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE cardapio_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    preco DOUBLE,
    estabelecimento_id BIGINT,
    FOREIGN KEY (estabelecimento_id) REFERENCES estabelecimento(id)
);

CREATE TABLE pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT,
    item_id BIGINT,
    data_pedido DATETIME,
    FOREIGN KEY (cliente_id) REFERENCES user(id),
    FOREIGN KEY (item_id) REFERENCES cardapio_item(id)
);
