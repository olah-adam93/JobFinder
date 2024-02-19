-- Dummy data for tb_client table
INSERT INTO tb_client (client_name, email, api_key)
VALUES ('John Doe', 'john.doe@example.com', '123e4567-e89b-12d3-a456-426614174000'),
       ('Jane Smith', 'jane.smith@example.com', '123e4567-e89b-12d3-a456-426614174001'),
       ('Michael Johnson', 'michael.johnson@example.com', '123e4567-e89b-12d3-a456-426614174002');

-- Dummy data for tb_position table
INSERT INTO tb_position (position_name, location, url)
VALUES ('Software Engineer', 'San Francisco, CA', 'https://indeed.com/san_francisco_ca/software_engineer/1'),
       ('Product Manager', 'New York, NY', 'https://indeed.com/new_york_ny/product_manager/2'),
       ('Data Scientist', 'Chicago, IL', 'https://indeed.com/chicago_il/data_scientist/3');
