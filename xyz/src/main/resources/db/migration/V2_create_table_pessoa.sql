CREATE TABLE pessoa (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        cpf VARCHAR(20) NOT NULL,
                        age INTEGER
);