CREATE TABLE IF NOT EXISTS branch (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  key VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  address TEXT NOT NULL,
  province_code VARCHAR(255) NOT NULL,
  province_name VARCHAR(255) NOT NULL,
  city_code VARCHAR(255) NOT NULL,
  city_name VARCHAR(255) NOT NULL,
  district_code VARCHAR(255) NOT NULL,
  district_name VARCHAR(255) NOT NULL,
  subdistrict_code VARCHAR(255) NOT NULL,
  subdistrict_name VARCHAR(255) NOT NULL,
  zipcode VARCHAR(255) NOT NULL,
  active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_user VARCHAR(255) DEFAULT 'system',
  updated_date TIMESTAMP NULL,
  updated_user VARCHAR(255),
  CONSTRAINT uq_branch_key UNIQUE (key)
);

DROP INDEX IF EXISTS idx_branch_key;
CREATE INDEX idx_branch_key ON branch (key);