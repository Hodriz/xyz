CREATE TABLE veiculo (
                         id BIGSERIAL PRIMARY KEY,
                         modelo VARCHAR(100) NOT NULL,
                         marca VARCHAR(100) NOT NULL,
                         funcao VARCHAR(100),
                         ano INTEGER
);