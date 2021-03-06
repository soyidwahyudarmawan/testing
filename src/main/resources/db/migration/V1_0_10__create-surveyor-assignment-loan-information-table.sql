CREATE TABLE IF NOT EXISTS surveyor_assignment_loan_information (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  assignment_id BIGINT NOT NULL,
  amount NUMERIC(17, 2) NULL,
  tenor INTEGER NULL,
  installment_amount NUMERIC(17, 2) NULL,
  active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_user VARCHAR(255) DEFAULT 'system',
  updated_date TIMESTAMP NULL,
  updated_user VARCHAR(255),
  CONSTRAINT fk_surveyor_assignment_loan_information_surveyor_assignment_assignment_id FOREIGN KEY (assignment_id) REFERENCES surveyor_assignment (id)
);
