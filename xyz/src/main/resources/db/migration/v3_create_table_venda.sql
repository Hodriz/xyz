CREATE TABLE venda (
                       id BIGSERIAL PRIMARY KEY,
                       pessoa_id BIGINT,
                       veiculo_id BIGINT UNIQUE,
                       date TIMESTAMP,
                       valor NUMERIC(10,2),

                       CONSTRAINT fk_venda_pessoa
                           FOREIGN KEY (pessoa_id)
                               REFERENCES pessoa(id),

                       CONSTRAINT fk_venda_veiculo
                           FOREIGN KEY (veiculo_id)
                               REFERENCES veiculo(id)
);