class DropColsFromQuestions < ActiveRecord::Migration
  def change
	  remove_column :questions, :user_id, :text
	  remove_column :questions, :options, :text
  end
end
