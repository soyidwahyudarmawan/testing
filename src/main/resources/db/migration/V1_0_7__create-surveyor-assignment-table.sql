CREATE TABLE IF NOT EXISTS surveyor_assignment (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  application_id UUID NOT NULL,
  application_number VARCHAR(255) NOT NULL,
  lead_id UUID NOT NULL,
  lead_number VARCHAR(255) NOT NULL,
  surveyor_id VARCHAR(255) NULL,
  assignment_type VARCHAR(255) NOT NULL,
  assignment_status VARCHAR(255) NOT NULL,
  loaded BOOLEAN DEFAULT FALSE,
  branch_id BIGINT NULL,
  product_id BIGINT NOT NULL,
  active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_user VARCHAR(255) DEFAULT 'system',
  updated_date TIMESTAMP NULL,
  updated_user VARCHAR(255),
  CONSTRAINT fk_surveyor_assignment_application_application_id FOREIGN KEY (application_id) REFERENCES application (id),
  CONSTRAINT fk_surveyor_assignment_branch_branch_id FOREIGN KEY (branch_id) REFERENCES branch (id)
);

DROP INDEX IF EXISTS idx_assignment_type;
CREATE INDEX idx_assignment_type ON surveyor_assignment (assignment_type);

DROP INDEX IF EXISTS idx_assignment_status;
CREATE INDEX idx_assignment_status ON surveyor_assignment (assignment_status);